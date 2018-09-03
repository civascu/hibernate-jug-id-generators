package com.imc.hibernate.id;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;


public class TimeBasedUrlSafeIdGenerator implements IdentifierGenerator {

  /**
   * Generate a URL safe UUID that is ordered bassed on the time and the device's NIC info.
   * Uses the {@link com.fasterxml.uuid.impl.TimeBasedGenerator} for the underlying implementation.
   *
   * @param session The session from which the request originates
   * @param obj     the entity or collection (idbag) for which the id is being generated
   * @return a new identifier, as a lower-case string.
   */
  @Override
  public Serializable generate(SharedSessionContractImplementor session,
                               Object obj) {
    return Generators.timeBasedGenerator(EthernetAddress.fromInterface())
        .generate()
        .toString()
        .replace("-", "")
        .toLowerCase();
  }
}
