package zw.co.nbs.gatewayservicecharges.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.nbs.gatewayservicecharges.business.Impl.ChargesServiceImpl;
import zw.co.nbs.gatewayservicecharges.business.api.ChargesService;

@Configuration
public class configs {

    @Bean
    public ChargesService chargesService(final ApplicationContext context) {
        return new ChargesServiceImpl(context);
    }
}
