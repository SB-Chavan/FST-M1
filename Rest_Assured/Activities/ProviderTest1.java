package activities;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.Provider;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junit5.PactFolder;
import au.com.dius.pact.provider.junitsupport.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class ProviderTest1 {

    @BeforeEach
    void setUp(PactVerificationContext context) {

        // Target provider API running locally
        HttpTestTarget target = new HttpTestTarget("localhost", 8585);

        context.setTarget(target);
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void providerTest(PactVerificationContext context) {

        // Verify the interaction from the pact contract
        context.verifyInteraction();
    }

    // Provider state defined in ConsumerTest
    @State("POSTRequest")
    public void postRequestState() {

        // Prepare provider state if required
        // Example: Insert test data in DB
    }

}
