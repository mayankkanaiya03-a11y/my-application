# **Q-3 or a**







## Course.java





@Entity

public class Course {

&#x20;   @Id

&#x20;   @GeneratedValue(strategy = GenerationType.IDENTITY)

&#x20;   private Long id;

&#x20;   private String title;

&#x20;   private Integer duration;

&#x20;   private String instructorName;



&#x20;   // Getters and Setters

&#x20;   public Long getId() { return id; }

&#x20;   public void setId(Long id) { this.id = id; }

&#x20;   public String getTitle() { return title; }

&#x20;   public void setTitle(String title) { this.title = title; }

&#x20;   public Integer getDuration() { return duration; }

&#x20;   public void setDuration(Integer duration) { this.duration = duration; }

&#x20;   public String getInstructorName() { return instructorName; }

&#x20;   public void setInstructorName(String instructorName) { this.instructorName = instructorName; }

}







## CourseNotFoundException.java







class CourseNotFoundException extends RuntimeException {

&#x20;   public CourseNotFoundException(String message) {

&#x20;       super(message);

&#x20;   }

}







## CourseRepository.java





interface CourseRepository extends JpaRepository<Course, Long> {

}



## 

## CourseService.java





@Service

class CourseService {

&#x20;   @Autowired

&#x20;   private CourseRepository courseRepository;



&#x20;   public Course createCourse(Course course) {

&#x20;       return courseRepository.save(course);

&#x20;   }



&#x20;   public void deleteCourse(Long id) {

&#x20;       if (!courseRepository.existsById(id)) {

&#x20;           throw new CourseNotFoundException("Course Not Found with ID: " + id);

&#x20;       }

&#x20;       courseRepository.deleteById(id);

&#x20;   }

}







## CourseController.java





@RestController

class CourseController {



&#x20;   @Autowired

&#x20;   private CourseService courseService;





&#x20;   // Exception Handler specific to this controller

&#x20;   @ExceptionHandler(CourseNotFoundException.class)

&#x20;   public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException ex) {

&#x20;       return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT\_FOUND);

&#x20;   }





&#x20;   @PostMapping("/courses")

&#x20;   public Course createCourse(@RequestBody Course course) {

&#x20;       return courseService.createCourse(course);

&#x20;   }



&#x20;   @DeleteMapping("/courses/{id}")

&#x20;   public String deleteCourse(@PathVariable Long id) {

&#x20;       courseService.deleteCourse(id);

&#x20;       return "Course deleted successfully";

&#x20;   }

}





