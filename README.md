# driving-simulator

	Driving Simulator in a grid of 5 * 5 currently. Can be extended in future releases

### Project dependencies

	The project requires Java 1.7 or higher and gradle version 1.12
	
### Checkout from git

	git clone git@github.com:bharath-carsim/driving-simulator.git
	
### Building and Running the project

	Execute 'gradle clean build' from the project root directory to build the project.
	
	This should also run the junit testcases and create an executable jar file 
	'driving-simulator.jar' in the build/libs directory.
	
	Run the simulator on a data file using the following command :
	
	java -jar build/libs/driving-simulator.jar <path_to_input_data_file>
	
	Run the simulator with commands from commandline using the following command :
	
	java -jar build/libs/driving-simulator.jar