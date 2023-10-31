package weijuly.enterprise.bookstore.data;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

public class UUIDSequenceGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor implementor, Object object) {
        return UUID.randomUUID().toString();
    }
}
