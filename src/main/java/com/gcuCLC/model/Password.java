package com.gcuCLC.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Password
{
	@NotNull(message="Password is a Required Field")
	@Size(min=1, max=32, message="Password Must be Between 1 & 32 characters")
    private String curPassword;

	@NotNull(message="Password is a Required Field")
	@Size(min=1, max=32, message="Password Must be Between 1 & 32 characters")
    private String newPassword;

	@NotNull(message="Code is a Required Field")
    private int code;


    public Password() 
    {

    }

    public String getCurPassword() 
    {
        return this.curPassword;
    }

    public void setCurPassword(String curPassword) 
    {
        this.curPassword = curPassword;
    }

    public String getNewPassword() 
    {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) 
    {
        this.newPassword = newPassword;
    }

    public int getCode() 
    {
        return this.code;
    }

    public void setCode(int code) 
    {
        this.code = code;
    }
}