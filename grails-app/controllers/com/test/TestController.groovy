package com.test

class TestController {

    def index() { 
    	def data = Data.first()
    	render text: data.response
    }
}
