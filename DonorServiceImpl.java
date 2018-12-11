package com.cg.donor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.dao.DonorDAOImpl;
import com.cg.donor.dao.IDonorDAO;
import com.cg.donor.exception.DonorException;

public class DonorServiceImpl implements IDonorService{

	IDonorDAO donordao= new DonorDAOImpl();
	@Override
	public String addDonor(DonorBean donor) throws DonorException {
		
		String donorSeq;
		donorSeq=donordao.addDonor(donor);	
		return donorSeq;
	}

	@Override
	public DonorBean viewDonorDetails(String donorId) throws DonorException {
		
		
		return null;
	}

	@Override
	public List retrieveAllDonors() throws DonorException {
			
		return null;
	}
	
	public void validateDonor(DonorBean bean) throws DonorException
	{
		
		List<String> validationErrors = new ArrayList<String>();
		
		
		if(!(isValidName(bean.getDonorName())))
		{
			validationErrors.add("\n Donor Name should be in Alphabets and Minimum 3 character long \n");
		}
		
		if(!(isValidAddress(bean.getAddress())))
		{
			validationErrors.add("\n Address Should be 5 character long \n");
		}
		
		if(!(isValidPhoneNumber(bean.getPhoneNumber())))
		{
			validationErrors.add("\n Phone Number Should be in 10 digits \n");
		}
		
		if(!(isValidDonationAmount(bean.getDonationAmount())))
		{
			validationErrors.add("\n Please provide Valid Amount \n");
		}
		
		private boolean isValidDonationAmount(double donationAmount)
		{
			return donationAmount>0;
		}
		
		
		private boolean isValidPhoneNumber(String phoneNumber)
		{
			Pattern phonePattern = Pattern.compile("^[6-9][0-9]{9}$");
			Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
			return phoneNumber.matches();
		}
		
		private boolean isValidAddress(String address)
		{
			
			return (address.length()>6);
		}
		
		private boolean isValidName(String donorName)
		{
			
			Pattern namePattern = Pattern.compile("^[A-Za-z]{3,}$");
			Matcher nameMatcher = namePattern.matcher(donorName);
			return nameMatcher.matches();
		}
		
		private boolean validateDonorId(String donorId)
		{
			Pattern idPattern = Pattern.compile("[0-9]{1,4}");
			Matcher idMatcher= idPattern.matcher(donorId);
			
			if(idMatcher.matches())
				return true;
			else
				return false;
		}
		
	}

