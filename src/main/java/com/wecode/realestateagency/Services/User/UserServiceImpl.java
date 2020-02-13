package com.wecode.realestateagency.Services.User;


import com.wecode.realestateagency.Models.Agency;
import com.wecode.realestateagency.Models.Client;
import com.wecode.realestateagency.Models.Local;
import com.wecode.realestateagency.Models.User;
import com.wecode.realestateagency.Repositories.LocalRepository;
import com.wecode.realestateagency.Repositories.UserRepository;
import com.wecode.realestateagency.Services.Agency.AgencyService;
import com.wecode.realestateagency.Services.Client.ClientService;
import com.wecode.realestateagency.Services.Local.LocalService;
import com.wecode.realestateagency.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private RoleRepository roleRepository;

	/**
	 *
	 */
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private LocalRepository localRepository;




	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		return null;
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//		user.getRoles().forEach(role -> {
//			//authorities.add(new SimpleGrantedAuthority(role.getName()));
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//		});
//		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void addLocaltoWishlist(Long idUser, Long idLocal) {
		User user =  userRepository.findById(idUser).get();
		Local local = localRepository.findById(idLocal).get();
		user.getWishList().add(local);
		local.getUserWished().add(user);
		userRepository.saveAndFlush(user);
	}

	@Override
	public void removeLocalfromWishlist(Long idUser, Long idLocal) {
		User user =  userRepository.findById(idUser).get();
		Local local = localRepository.findById(idLocal).get();
		user.getWishList().remove(local);
		local.getUserWished().remove(user);
		userRepository.saveAndFlush(user);
	}


//	@Override
//    public User save(UserDto user) {
//	    User newUser = new User();
//		if(user.getIdUser() != null)
//	    newUser.setIdUser(user.getIdUser());
//
//	    newUser.setUsername(user.getUsername());
//	    if (user.getPassword() != null)
//	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//	    else
//	    	newUser.setPassword(findById(newUser.getIdUser()).getPassword());
//		newUser.setSalary(user.getSalary());
//		newUser.setBirthdate(user.getBirthdate());
//		newUser.setEmail(user.getEmail());
//		newUser.setAddress(user.getAddress());
//		newUser.setCin(user.getCin());
//		newUser.setLeaveBalance(user.getLeaveBalance());
//		newUser.setFirstName(user.getFirstName());
//		newUser.setLastName(user.getLastName());
//		newUser.setRib(user.getRib());
//		newUser.setLinkedin(user.getLinkedin());
//		newUser.setFacebook(user.getFacebook());
//		newUser.setInstagram(user.getInstagram());
//		if( user.getRoles() != null){
//
//            for (String role: user.getRoles()) {
//                newUser.getRoles().add(roleRepository.findByName(role));
//            }
//        }
//		else{
//            newUser.getRoles().add(roleRepository.findByName("USER" +
//                    ""));
//
//        }
//
//
//		return userRepository.save(newUser);
//    }
@Override
    public User update(User user){
		return userRepository.save(user);

	}

	@Override
	public boolean changePassword(ChangePasswordVM vm , String username){
		User user = findOne(username);
		System.out.println("----------------"+passwordEncoder.encode(vm.getOldPassword()) + "--------------------" + user.getPassword());
		System.out.println("------" + vm.getOldPassword());

		if (passwordEncoder.matches(vm.getOldPassword(),user.getPassword())){
			user.setPassword(passwordEncoder.encode(vm.getNewPassword()));
			userRepository.save(user);
			return true;
		}
		else return false;

	}




}
