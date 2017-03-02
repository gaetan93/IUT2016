@Component
public static class BatchRunner implements CommandLineRunner{
 @Autowired DataSource ds;
 @Autowired JdbcTemplate jdbcTemplate;
 @Autowired EntityManager em;
 @Autowired SimpleRepository repo;

 @Override	
 @Transactional
 public void run(String...arg0) throws Exception{
	String res = jdbcTemplate.execute("select 'Hello'", |PreparedStatement stat)
		ResultSet rs = stat.executeQuery();
		rs.next();
		return rs.getString(I);
	});
	system.out.println(res);

	Simple e = new Simple[];
	e.setName("john");
	em.persist(e);
	em.flush[];

	String jpaQl = "select e from Simple e where e.name = ?";
	List<Simple> ls = em.createQuery(jpaQl).setParameter(1, "john")

	List<Simple> ls2 = repo.findAllByName("john");

	System.out.println(ls2);
     }

   }

}