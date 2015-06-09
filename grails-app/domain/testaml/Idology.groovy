package testaml

class Idology {
	String response

    static constraints = {
    	response size:0..5000
    }
}
