package com._SpringSecurity.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com._SpringSecurity.Common;
import com._SpringSecurity.Dao.ProductDao;
import com._SpringSecurity.Dao.VendorDao;
import com._SpringSecurity.Service.AddressService;
import com._SpringSecurity.Service.CartService;
import com._SpringSecurity.Service.EmployeeService;
import com._SpringSecurity.Service.OrderService;
import com._SpringSecurity.Service.ProductService;
import com._SpringSecurity.Service.VendorService;
import com._SpringSecurity.entity.Address;
import com._SpringSecurity.entity.Cart;
import com._SpringSecurity.entity.Employee;
import com._SpringSecurity.entity.Orders;
import com._SpringSecurity.entity.Product;
import com._SpringSecurity.entity.Vendors;

@RestController
@RequestMapping("/v1")
public class TestController {
	@Autowired 
	EmployeeService employeeService;
	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;
	@Autowired
	OrderService orderService;
	
	@Autowired 
	VendorService vendorService;
	
	
	@Autowired
	AddressService addressService;
	
	
	
//			VendorSection     all Vendor Api.....

	@PostMapping ("/saveVendor")
	public Vendors saveVendor( @RequestBody Vendors vendor) {
			
		return vendorService.saveVendor(vendor);
	}
	
 
	
	@GetMapping("/home")
	public String home() {
		
		
		return "homePage";
	}
	
//	Employee Sections

	@GetMapping("/emp/{id}")
		public Employee getEmloyee(@PathVariable int id) {		
		return employeeService.findEmployeeById(id);
		}
	@GetMapping("/emps")
	public List<Employee> getAllEmloyee() {		
	return employeeService.findAllEmployees();
	}
	
	@PutMapping("/empUpdate")
	public Employee updateEmloyee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}
	
	
	@PostMapping("/saveEmp")
	public Employee saveEmloyee(@RequestBody Employee emp) {	
		return employeeService.saveEmployee(emp);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Employee emp) {

		String varify = employeeService.varify(emp);
		Employee emp1 = employeeService.findEmployeeByUserName(emp.getUsername());

		System.out.println("token is : " + varify);

		Optional<Vendors> vendors = vendorService.getVendorsById(emp.getUsername());
		Vendors vendor = null;
		if (vendors.isPresent()) {
			vendor = vendors.get();
		}

		Map<String, Object> map = new HashMap<>();
		if (emp1 != null) {
			map.put("empId", emp1.getId());
			map.put("roll", "user");
		} else if (vendor != null) {
			map.put("empId", vendor.getVenderId());
			map.put("roll", "vendor");
		}
		map.put("token", varify);

		return ResponseEntity.ok(map);

	}
	
	
	
	@GetMapping("/getAddressTempByEmpId/{empId}")
	public List<Address> getAddressByEmpId(@PathVariable int empId){	
		List<Address> address = getEmloyee(empId).getAddress();
		 return address;	
	}
	
	
	
	
//	ProductSection
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<Map<String, Object>> getAllProduct(){
		
		List<Product> allProduct1 = productService.getAllProduct();
//		Set<Product> allProduct = productService.randomProductList(allProduct1);
		Set<Product> allProduct= new HashSet<>(allProduct1);
				
		
		Map<String, Object> map= new HashMap<>();
		map.put("productList", allProduct );
		
		return ResponseEntity.ok(map);	
	}
	

	
	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Map<String, Product>> getProductById(@PathVariable Integer id){
		Product productById = productService.getProductById(id);
		Map<String, Product> map= new HashMap<>();
		map.put("product", productById );
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		
		
		Vendors vendors = vendorService.getVendorsById(product.getVendorId()).get();
		System.out.println("Vendor print : "+vendors);
		
		List<Product> products = vendors.getProducts();
		products.add(product);
		vendors.setProducts(products);
	
		
		vendorService.saveAndUpdateVendor(vendors);
		//productService.saveProduct(product)
		return product;
	}
	
	@GetMapping("/getProductByVendorId/{vendorId}")
	public ResponseEntity<Map<String, List<Product>>> getProductByVendorId(@PathVariable String vendorId){
		List<Product> allProduct = productService.getProductByVendorId(vendorId);
		Map<String, List<Product>> map= new HashMap<>();
		map.put("productList", allProduct );
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/searchProduct/{search}")
	public List<Product> searchProduct(@PathVariable String search){
		
		
		return productService.searchProduct(search);
	}
	
	
	
	
	
//	Cart Section
	
	@PostMapping("/saveCart")
	public Cart saveCart(@RequestBody Cart cart) {
	
		
		return cartService.saveCart(cart);
	}
	@GetMapping("/getCardByCartId/{id}")
	public Cart findCartByCartId(@PathVariable int id){
		return cartService.findCartByCartId(id);
	}
	@GetMapping("/getCardByEmpId/{id}")
	public List<Cart> findCartByEmpId(@PathVariable int id){
		return cartService.findByEmpId(id);
	}
	
	@PutMapping("/deleteCartById/{cartId}")
	public String cartDeleteByCartId(@PathVariable int cartId) {
		
		return cartService.deleteCartById(cartId);
	}
	
//	 order Section
	
	@PostMapping("/saveOrders")
	public Orders postMethodName(@RequestBody Orders order) {
		
		System.out.println("Order Is : "+order);
	
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/getOrderByEmpId/{empId}")
	public List<Orders> getOrderByEmpId(@PathVariable int empId){
		
		return orderService.findOrdersByEmpId(empId);
	}
	@GetMapping("/getOrderByVendorId/{vendorId}")
	public List<Orders> getOrderByEmpId(@PathVariable String vendorId){
		
		List<Orders> ordersByVendorId = orderService.findOrdersByVendorId(vendorId);
		
	
		
		return ordersByVendorId; 
	}
	@GetMapping("/getAllOrders")
	public List<Orders> getOrders(){	
		return orderService.getAll(); 
	}
	
	
	@GetMapping("/deleteOrderById/{orderId}")
	public String deleteOrderById(@PathVariable String orderId) {
		
		return orderService.deleteOrderById(orderId);
	}
	
	
	@PutMapping("/updateOrderStatusByOrderId/{orderId}/{status}")
	public Orders updateOrderStatusByOrderId(@PathVariable String orderId,@PathVariable String status) {
		
		return orderService.updateOrderStatusByOrderId(orderId,status);
	}
	
	
	
	
	
	
//	------------------------------------------------------------------------------------------------
	
	
	
//	address field
	@PutMapping("/updatEmpAddress/{empId}")
		public Employee updateEmployeeAddress(@PathVariable int empId, @RequestBody Address address ) {
			
			return employeeService.updateEmployeeAddress(empId,address);
		}
	
		
	@GetMapping("/getAddressById/{id}")
	public Address getAddressById(@PathVariable int id) {
		
		return addressService.getAddressById(id);
	}
		
}
