package com.jskno.taskmanagement.sandbox.factorybean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class EmployeeFactoryBean extends AbstractFactoryBean<EmployeeDTO> {

    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public Class<?> getObjectType() {
        return EmployeeDTO.class;
    }

    @Override
    protected EmployeeDTO createInstance() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(-1);
        employee.setFirstName("dummy");
        employee.setLastName("dummy");
        //Set designation here
        employee.setDesignation(designation);
        return employee;
    }
}
