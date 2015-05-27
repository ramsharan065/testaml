package com.test

class TestController {

    def index() { 
    	//def data = Data.last()
    	//render data?.response
    	render '{"res":"MANUAL_REVIEW", "frd":"from own api"}'
    }

    def accept(){
    	render '{"message":"Feedback accepted for MERCHANT_DENY_DEFAULT feedback on transaction TR-90000009-0010"}'
    }

    def reject(){
    	render '{"message":"Feedback accepted for MERCHANT_DENY_DEFAULT feedback on transaction TR-90000009-0010"}'
    }
}
