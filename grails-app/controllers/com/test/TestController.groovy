package com.test

class TestController {

    def index() { 
    	def data = Data.last()
    	render data?.response
    }
}
