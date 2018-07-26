import org.springframework.stereotype.Controller;

@Controller
public class WelcomeService {
	
	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloService helloService;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());

		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		model.addObject("title", helloService.getTitle(name));
		model.addObject("msg", helloService.getDesc());

		return model;

	}

}
