package com.jskno.taskmanagement.sandbox.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class ITEmployeeFactoryBean implements FactoryBean<EmployeeDTO> {

    private boolean isSingletonBean;
    private String designation;

    public ITEmployeeFactoryBean(boolean isSingletonBean, String designation) {
        this.isSingletonBean = isSingletonBean;
        this.designation = designation;
    }

    public boolean isSingletonBean() {
        return isSingletonBean;
    }

    public void setSingletonBean(boolean singletonBean) {
        isSingletonBean = singletonBean;
    }

    public String isDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public EmployeeDTO getObject() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(9);
        employee.setFirstName("IT");
        employee.setLastName("IT");
        //Set designation here
        employee.setDesignation(designation);
        return employee;
    }

    @Override
    public Class<?> getObjectType() {
        return EmployeeDTO.class;
    }

    @Override
    public boolean isSingleton() {
        return isSingletonBean;
    }
}
