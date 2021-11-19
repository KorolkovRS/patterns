package behavioral.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

abstract class AuthenticationProcessor {
    protected AuthenticationProcessor nextProcessor;

    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isAuthorized(AuthenticationProvider authenticationProvider);
}

class OAuthProcessor extends AuthenticationProcessor {

    public OAuthProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authenticationProvider) {
        if (authenticationProvider instanceof OAuthProvider) {
            System.out.println("OAuth ok");
            return true;
        } else if (nextProcessor != null) {
            return this.nextProcessor.isAuthorized(authenticationProvider);
        }
        return false;
    }
}

class UsernamePasswordProcessor extends AuthenticationProcessor {

    public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authenticationProvider) {
        if (authenticationProvider instanceof UsernamePasswordProvider) {
            System.out.println("User & password ok");
            return true;
        } else if (nextProcessor != null) {
            return this.nextProcessor.isAuthorized(authenticationProvider);
        }
        return false;
    }
}

abstract class AuthenticationProvider {}

class OAuthProvider extends AuthenticationProvider { }

class UsernamePasswordProvider extends AuthenticationProvider { }

class SomethingProvider extends AuthenticationProvider { }

class Solution {
    public static void main(String[] args) {
        List<AuthenticationProvider> authenticationProviders = new ArrayList<>();
        authenticationProviders.add(new UsernamePasswordProvider());
        authenticationProviders.add(new OAuthProvider());
        authenticationProviders.add(new SomethingProvider());

        AuthenticationProcessor authenticationProcessor = new UsernamePasswordProcessor(new OAuthProcessor(null));

        for (AuthenticationProvider authenticationProvider: authenticationProviders) {
            System.out.println(authenticationProcessor.isAuthorized(authenticationProvider));
        }
    }
}


