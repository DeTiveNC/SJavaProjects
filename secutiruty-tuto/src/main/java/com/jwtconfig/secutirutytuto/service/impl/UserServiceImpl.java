    package com.jwtconfig.secutirutytuto.service.impl;

    import com.jwtconfig.secutirutytuto.repository.UserRepository;
    import com.jwtconfig.secutirutytuto.service.UserService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;

        @Override
        public UserDetailsService userDetailsService() {
            return new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    return userRepository.findByEmail(username)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
                }
            };
        }
    }
