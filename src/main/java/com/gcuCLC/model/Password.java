package com.gcuCLC.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group H1
 * Members   : W. Peterson, J. LeVan, and I. Gudino
 * Date      : 2022-03-11
 * Class     : CST-339 Java Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Model - Password
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

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


	/**
	 * No Args Password Constructor Method
	 */
    public Password() 
    {

    }

    /**
     * Getter - Current Password
     * @return Current Password
     */
    public String getCurPassword() 
    {
        return this.curPassword;
    }

    /**
     * Setter - Current Password
     * @param curPassword - String
     */
    public void setCurPassword(String curPassword) 
    {
        this.curPassword = curPassword;
    }

    /**
     * Getter - New Password
     * @return New Password
     */
    public String getNewPassword() 
    {
        return this.newPassword;
    }

    /**
     * Setter - New Password
     * @param newPassword - String
     */
    public void setNewPassword(String newPassword) 
    {
        this.newPassword = newPassword;
    }

    /**
     * Getter - Emailed Code to Change Password
     * @return Code to change password
     */
    public int getCode() 
    {
        return this.code;
    }

    /**
     * Setter - Emailed Code to Change Password
     * @param code - int
     */
    public void setCode(int code) 
    {
        this.code = code;
    }
}