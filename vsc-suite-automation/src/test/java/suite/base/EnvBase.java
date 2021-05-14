package suite.base;

import suite.testdata.AppData;

/**
 * @author kuldeepl
 *
 */

public class EnvBase {

	
	/**
	 * get environment variable
	 * 
	 * @return baseurl of environment
	 */
	
	private String env;

	public String getEnv()
	{
		return env;
	}
	
	
	
	/**
	 * Set environment variables
	 * 
	 * @param env
	 *
	 */

	
	public void setEnv(String env) {
		switch (env) {
		case "fujitsu":
			this.env = AppData.FUJITSU;
			break;

		case "lenovo":
			this.env = AppData.LENOVO;
			break;
			
		case "netapp":
			this.env= AppData.NETAPP;
			break;
			
		default:
			this.env = AppData.FUJITSU;
			break;


		}

	}

}
