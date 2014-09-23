package org.springframework.security.saml.web;

import org.opensaml.saml2.core.Attribute;
import org.opensaml.xml.schema.XSString;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;

import java.util.List;

/**
 * Created by chrislin on 9/22/2014.
 */
public class MySamlUserDetailService implements SAMLUserDetailsService {

    @Override
    public Object loadUserBySAML(SAMLCredential sc) throws UsernameNotFoundException {
        System.out.println("\n\n--------------------------------------->");
        for (Attribute a: sc.getAttributes()) {
            System.out.println(a.getName() + " : " + ((XSString)a.getAttributeValues().get(0)).getValue());
        }
        System.out.println("<---------------------------------------\n\n");
        return new MyUserDetail();
    }
}
