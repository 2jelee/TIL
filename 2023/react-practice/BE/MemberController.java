package com.example.final_project.controller;

import com.example.final_project.dto.EmpInfoDto;
import com.example.final_project.mapper.DeptMapper;
import com.example.final_project.mapper.EmpInfoCompMapper;
import com.example.final_project.mapper.EmployeeMapper;
import com.example.final_project.model.EmpInfoComp;
import com.example.final_project.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final EmployeeMapper employeeMapper;
    private final EmpInfoCompMapper empInfoCompMapper;
    private final DeptMapper deptMapper;

    @GetMapping("/emp/{empno}")
    public ResponseEntity getMemberInfo(@PathVariable("empno") String empno){
        Employee emp = employeeMapper.findByUserId(empno).get();
        EmpInfoComp empInfoComp = empInfoCompMapper.findByEmpno(empno).get();

        EmpInfoDto empInfoDto  = EmpInfoDto.builder()
                                            .profile(emp.getProfile()) // 사진
                                            .deptName(deptMapper.findBydeptNo(empInfoComp.getDeptno())) //부서명
                                            .name(emp.getName()) // 이름
                                            .rank(empInfoComp.getRank()) // 직급
                                            .extensionNum(empInfoComp.getExtensionNum()) //내선번호;
                                            .build();

        return new ResponseEntity(empInfoDto, HttpStatus.OK);
    }

//    @PostMapping("/update")
//    public ResponseEntity updateMemberInfo(@ResponseBody Update update){

//    }





}
