package com.example.employee.controller;

import java.util.List;
import javax.validation.Valid;

import com.example.employee.model.Employee;
import com.example.employee.model.SearchForm;
import com.example.employee.payload.request.employeeRequest;
import com.example.employee.payload.response.MessageResponse;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Employee> getAll() {

        return employeeRepository.findAllEmpl();
    }

    private static final int emplMax = 5;


    @PostMapping("/search")
    public Page<Employee> search(
            // thông tin form tìm kiếm
            @RequestBody SearchForm sf) {

        Pageable pagination = PageRequest.of(sf.getPage(), emplMax,
                // nếu đúng thì thứ tự tăng đần ngược lại giảm dần
                sf.getSortOrder() ? Direction.DESC : Direction.ASC,
                // xếp theo trường nào ví dụ id, name, price
                sf.getOrderBy());

        // lấy sản phẩm
        Page<Employee> productPage = employeeRepository.findByFullnameContainingIgnoreCase(sf.getFullname(), pagination);

        return productPage;
    }


    @PostMapping(value = "/insertEmpl")
    public ResponseEntity<?> postMethodName(@RequestBody @Valid employeeRequest request) {

        try {
            Employee emp = new Employee();
            emp.setFullname(request.getFullname());
            emp.setPhoneNumber(request.getPhoneNumber());
            emp.setAddress(request.getAddress());
            emp.setEmail(request.getEmail());

            emp.setDepartments(request.getDepartments());

            employeeRepository.save(emp);
            return ResponseEntity.ok(new MessageResponse("success!"));
        } catch (Exception e) {
            
            return ResponseEntity.badRequest().body(new MessageResponse("error!"));
        }
    }

    @GetMapping(value = "getEmlById/{id}")
    public Employee getEmployeeByID(@PathVariable("id") int id) {

        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping(value = "/updateEmpl")
    public ResponseEntity<?> updateEmpl(@RequestBody @Valid Employee employee) {

        employeeRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("update success"));
    }

    @DeleteMapping(value = "deleteEmplById/{id}")
    public ResponseEntity<?> deleteEmplById(@PathVariable("id") int id) {

        employeeRepository.deleteById(id);

        return ResponseEntity.ok(new MessageResponse("remove employee success!"));
    }

}
