class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "im/account/transfer"(controller:'test', action: 'index')

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
