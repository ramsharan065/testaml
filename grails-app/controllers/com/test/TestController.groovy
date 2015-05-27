package com.test

class TestController {

    def index() { 
    	def data = Data.find()
    	render text: data.response
    }
}
