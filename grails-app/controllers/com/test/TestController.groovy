package com.test

import testaml.*

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

    def idology(){
        def defaultResponse = '''<?xml version="1.0"?>
<response>
    <id-number>1124550715</id-number>
    <summary-result>
        <key>id.success</key>
        <message>PASS</message>
    </summary-result>
    <results>
        <key>result.match</key>
        <message>ID Located</message>
    </results>
    <id-scan>no</id-scan>
</response>'''

        def data = Idology.last()
        render data?.response ?: defaultResponse
    }

    def idologyAnswerResponse(){
        def data = IdologyAnswer.last()
        render data?.response
    }
}
