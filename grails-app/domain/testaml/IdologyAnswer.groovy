package testaml

class IdologyAnswer {
	String response

    static constraints = {
    	response size:0..5000
    }
}
