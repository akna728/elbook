package com.example.demo.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserList;
import com.example.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ユーザー名を使用してデータベースからユーザー情報を取得する処理を実装する
        UserList userInfo = userRepository.findByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // CustomUserDetails インスタンスを作成して返す
        return new CustomDetails(userInfo);
        
//		 userRepository.findByUsername(username)
//		.map(
//				user -> new CustomUserDetails(
//						user.getUser_name(),
//						user.getPass(),
////						Collections.emptyList()
//						toGrantedAuthorityList(user.getAuthority())
//				)
//		)
//		.orElseThrow(
//				() ->new UsernameNotFoundException(
//						"Given user_name is not found. (username = '" + username + "')"
//				)
//		);
    }
	
//	private List<GrantedAuthority>toGrantedAuthorityList(UserList.Authority authority){
//		return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));		
//}

}
