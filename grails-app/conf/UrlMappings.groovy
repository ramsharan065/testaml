class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/im/account/transfer"(controller:'test', action: 'index')
        "/im/transaction/$txnid/accepted-default"(controller:'test', action: 'accept')
        "/im/transaction/$txnid/rejected-default"(controller:'test', action: 'reject')
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
