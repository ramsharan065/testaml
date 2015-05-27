package com.test

class TestController {

    def index() { 
    	def data = Data.first()
    	render data.response
    }
}
