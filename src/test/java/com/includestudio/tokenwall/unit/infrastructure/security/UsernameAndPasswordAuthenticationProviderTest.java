package com.includestudio.tokenwall.unit.infrastructure.security;

import com.includestudio.tokenwall.application.AuthenticationService;
import com.includestudio.tokenwall.infrastructure.security.UsernameAndPasswordAuthenticationProvider;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

import static org.easymock.EasyMock.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Since: 7/5/12
 */
public class UsernameAndPasswordAuthenticationProviderTest {

    private Authentication authentication;
    private UsernameAndPasswordAuthenticationProvider provider;
    private AuthenticationService authenticationService;

    private static final class FakeAuthentication implements Authentication {

        private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.authorities;
        }

        @Override
        public Object getCredentials() {
            return "password";
        }

        @Override
        public Object getDetails() {
            throw new UnsupportedOperationException("getDetails");
        }

        @Override
        public Object getPrincipal() {
            return "username";
        }

        @Override
        public boolean isAuthenticated() {
            throw new UnsupportedOperationException("isAuthenticated");
        }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            throw new UnsupportedOperationException("setAuthenticated");
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("getName");
        }
    }

    @Before
    public void setUp() throws Exception {
        authentication = new FakeAuthentication();
        provider = new UsernameAndPasswordAuthenticationProvider();
        authenticationService = createMock(AuthenticationService.class);
        provider.setAuthenticationService(authenticationService);
    }

    @Test
    public void should_return_valid_authentication_with_role_any_when_valid_credential() throws Exception {
        expect(authenticationService.authenticate((String) authentication.getPrincipal(), (String) authentication.getCredentials())).andReturn(Boolean.TRUE);

        replay(authenticationService);
        Authentication result = provider.authenticate(authentication);
        verify(authenticationService);

        assertThat(result.getAuthorities().iterator().next().getAuthority(), is("ROLE_ANY"));
    }

    @Test
    public void should_throw_authentication_exception_when_invalid_credential() throws Exception {
        expect(authenticationService.authenticate((String) authentication.getPrincipal(), (String) authentication.getCredentials())).andReturn(Boolean.FALSE);

        replay(authenticationService);
        try {
            provider.authenticate(authentication);
            fail("should throw authentication exception.");
        } catch (AuthenticationException ae) {
            assertThat(ae.getMessage(), is("user name or password is not correct"));
        }
        verify(authenticationService);
    }
}
