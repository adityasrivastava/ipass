package com.mds.passkit.manager;

import com.mds.passkit.exception.PasskitException;
import com.ryantenney.passkit4j.Pass;

import java.io.IOException;

/**
 * Created by mradul on 07/03/16.
 */
public interface PassKitManager {

    void generate(Pass pass,String fileName,String p12Certificates,String appleWWDRCA,String password,String alias) throws PasskitException;

}
