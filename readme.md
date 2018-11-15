
What is a Web Service? how they are different from web application?

1. Web service is machine to machine, 
2. Exchange data between heterogenious systems.
3. Synchrounous communication.


JMS => specification given by sun micro systems.
	=> Tibco
	=> RabbitMQ
	=> ActiveMQ => apache software...
	
Data exchange model?	xml, json, yml, or custom.

what are different web services:
	1. REST
	2. SOAP


	REST: Representational State Transfer.
	usually we transfer state of a resource on the server to the client.
	
	will have
		1. Transport protocol.
		2. Messaging protocol.
		
	REST:
		http as both transport and messaging protocol.
		
	Http = support few protocol operations
		GET	=> Request some info from server.
		POST => to create new resources on the server we use post
		PUT	=> to update the resources, *(you can create resources)*
		DELETE => to delete resources on the server
		OPTIONS	=> to get the support protocol operations.
		TRACE => for debugging
		HEAD => header information
		PATCH => 
 ==============================================================================	
		How we can implement REST web services in java?
		
		For restful web services we have a specification available in java
		JAX-RS => FOR restFUL SERVICES	JSR 311 => First versioin, 339 second version.
		JAX-WS => soap based services.
		
		Reference Impmlementation:
			1. Jersy
		Any other implementation:
			2. Spring REST services
			3. Apache cxf
			4. xyz
			
			
			
			
			Two parties:
			
			Host and a consumer
			
			
			
			
			
			
			
			
			
	
	
	
	
		

	
