package com.example.demo.controller;

import com.example.demo.model.Roles;
import com.example.demo.services.RoleService;
import com.example.demo.services.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/role/read")
public class RoleController{
    @Autowired
    private final RoleService RoleService;

    public RoleController(RoleServiceImp RoleServiceImp){
        this.RoleService = RoleServiceImp;
    }
    //get list of Roles
    @GetMapping("")
    public List<Roles> getRoles(){
        return RoleService.getALLRoles();
    }
//    //get a Role by its id
//    @GetMapping("/{id}")
//    public Optional<Roles> getOneT(@PathVariable Long id){
//        return RoleService.findRoleById(id);
//    }
//    //create a new Role
//    @PostMapping("")
//    public Roles postTran(@RequestBody Roles Roles){
//        return  RoleService.insertTran(Roles);
//    }
//    //Update existed Role or new one if not existed
//    @PutMapping("/{id}")
//    public Roles putTran(@RequestBody Roles tran,@PathVariable Long id){
//        return RoleService.updateRole(tran,id);
//    }
//    //remove a Role by its id
//    @DeleteMapping("/{id}")
//    public void deleteTran(@PathVariable Long id){
//        RoleService.deleteRole(id);
//    }
}