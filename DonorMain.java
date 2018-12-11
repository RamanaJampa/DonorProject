package com.cg.donor.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.service.DonorServiceImpl;
import com.cg.donor.service.IDonorService;

public class DonorMain {
	
		static Scanner scan= new Scanner(System.in);
		static IDonorService donorService=null;
		static DonorServiceImpl donorServiceImpl=null;

	public static void main(String[] args) {
		
		DonorBean donorBean=null;
		
		String donorId=null;
		int option=0;
		
		while(true)
		{
			

			System.out.println();
			System.out.println();
			System.out.println("   ICARE CAPGEMINI TRUST   ");
			System.out.println("__________________________________");
			System.out.println("1- Add Donor");
			System.out.println("2- View Donor");
			System.out.println("3- Retrieve All");
			System.out.println("4- Exit");
			System.out.println("__________________________________");
			System.out.println(" Select An Option ");
		
		
			try
			{
			
				option =scan.nextInt();
				switch(option)
				{
				case 1: while(donorBean==null)
						{
							donorBean = populateDonorBean();
						}
						try
						{
							donorService = new DonorServiceImpl();
							donorId = donorService.addDonor(donorBean);
							System.out.println("Donor Details has been successfully registered");
							System.out.println("Donor ID is "+donorId);
						}
						catch(DonorException donorExcepption)
						{
							System.out.println("Error is :"+donorExcepption.getMessage());
						}
						finally
						{
							donorId=null;
							donorService=null;
							donorBean = null;
						}
				
				case 2:
					
					
				case 3:
					
					
				case 4:
					
					
					
				default: 
						break;
				}
			}
			catch(Exception e)
			{
			
			}
		}
	}

	private static DonorBean populateDonorBean() {
		DonorBean donorBean=new DonorBean();
		System.out.println("Enter Details: ");
		
		System.out.println("Enter Donor Name: ");
		donorBean.setDonorName(scan.next());
		
		System.out.println("Enter Phone Number: ");
		donorBean.setPhoneNumber(scan.next());
		
		System.out.println("Enter Address: ");
		donorBean.setAddress(scan.next());
		
		System.out.println("Enter Donation Amount: ");
		try
		{
		donorBean.setDonationAmount(scan.nextDouble());
		}
		catch(InputMismatchException ioe)
		{
			scan.next();
			System.err.println("Please Enter the numeric value for Donation Amount, Try Again !!!");
		}
		
		try
		{
			donorServiceImpl.validateDonor(donorBean);
			return donorBean;
		}
		catch(DonorException donorException)
		{
			System.err.println("Invalid Data");
			System.err.println(donorException.getMessage()+"\n Try Again !!");
			
		}
		return null;
	}
}
