## Интерфейс аннотаций PropertySource
@Target(ТИП) @Retention(ВРЕМЯ ВЫПОЛНЕНИЯ) @Documented

@Repeatable(PropertySources.class) public @interface PropertySource

Аннотация, предоставляющая удобный декларативный механизм для добавления a PropertySource к классам Spring Environment. Будет использоваться совместно с классами @Configuration.
Пример использования

Учитывая файл, app.properties содержащий пару ключ/ значение testbean.name=myTestBean, следующий @Configuration класс использует @PropertySource для внесения вклада app.properties в Environment набор PropertySources.

    @Конфигурация
    @PropertySource("путь к классу:/com/myco/app.properties")
    открытый класс AppConfig {

    @Autowired
    Environment env;

    @Bean
    public testBean testBean() {
        testBean testBean = new testBean();
            testBean.setName(env.getProperty("testbean.name"));
            возвращает testBean;
        }
    }

Обратите внимание, что Environment объект находится @Autowired в классе configuration, а затем используется при заполнении TestBean объекта. Учитывая приведенную выше конфигурацию, вызов testBean.getName() вернет "myTestBean".