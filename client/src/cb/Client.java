package cb;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

/**
 * Client.java
 *
 *
 * Created: Mon Sep 3 19:28:34 2001
 *
 * @author Nicolas Noffke
 */

public class Client extends CallBackPOA
{
    public Client ()
    {
    }

    public void call_back (String message)
    {
        System.out.println ("Client callback object received hello message >"
                + message + '<');
    }

    public static void main (String[] args) throws Exception
    {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args,null);

	/* Erhalten des RootContext des angegebenen Namingservices */
	org.omg.CORBA.Object o = orb.resolve_initial_references("NameService");
			
	/* Verwenden von NamingContextExt */
	NamingContextExt rootContext = NamingContextExtHelper.narrow(o);
			
	/* Angeben des Pfades zum Echo Objekt */
	NameComponent[] name = new NameComponent[2];
	name[0] = new NameComponent("test","my_context");
	name[1] = new NameComponent("Echo", "Object");
        
	//Testing
	//org.omg.CORBA.Object o = orb.string_to_object ("IOR:010000001200000049444c3a63622f5365727665723a312e30000000010000000000000064000000010102000e0000003139322e3136382e312e3131390039b40e000000fe5259f85600001a6c000000000000000200000000000000080000000100000000545441010000001c00000001000000010001000100000001000105090101000100000009010100");

        Server server = ServerHelper.narrow (rootContext.resolve(name));

	POA poa = POAHelper.narrow( orb.resolve_initial_references( "RootPOA" ));
        
        poa.the_POAManager ().activate ();

        CallBack cb = CallBackHelper.narrow (poa.servant_to_reference (new Client ()));
	
	System.out.println("Executing one-time callback.");	

        server.one_time (cb, "Hello! This is a test message.");

	System.out.println("Register periodically callback that is called every 2 seconds.");	

        server.register (cb, "I'm the 2 seconds callback.", (short) 2);

	System.out.println("Register periodically callback that is called every 3 seconds.");	
        server.register (cb, "This is another message (3 seconds).", (short) 3);

	System.out.println("Press [ENTER] to shut down the server.");
        while ( System.in.read() != '\n' );
	server.shutdown();
    }
}// Client
