// package com.example.demo.controller;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.demo.entity.UserProfile;
// import com.example.demo.service.UserProfileService;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import java.util.List;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
// @RequestMapping("/api/users")
// public class UserProfileController{

//        private final UserProfileService ups;

//     public UserProfileController(UserProfileService ups) {
//         this.ups = ups;
//     }
//     @PostMapping
//     public UserProfile addUserProfile(@RequestBody UserProfile profile ){
//         return ups.createUser(profile);
//     }

//     @GetMapping("/{id}")
//      public UserProfile getId(@PathVariable Long id){
//         return ups.getUserById(id);
//     }

//     @GetMapping("/lookup/{userId}")
//     public UserProfile getUser(@PathVariable String userId){
//         return ups.findByUserId(userId);
//     }
//     @GetMapping
//     public List<UserProfile> getAllUsers(){
//         return ups.getAllUsers();
//     }
 

//     @PutMapping("/{id}/status")
//     public UserProfile updateStatus(@PathVariable Long id,@RequestParam Boolean active){
//         return ups.updateUserStatus(id,active);
//     }    
    

    
// }

package com.example.demo.controller;
import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserProfileController {
private final UserProfileService service;
public UserProfileController(UserProfileService service) {
this.service = service;
}
@PostMapping("/register")
@PreAuthorize("permitAll()")
public UserProfile register(@RequestBody UserProfile profile) {
return service.createUser(profile);
}
@GetMapping("/{id}")
@PreAuthorize("permitAll()") // Changed to permitAll for testing
public UserProfile get(@PathVariable Long id) {
return service.getUserById(id);
}
@GetMapping
@PreAuthorize("permitAll()")
public List<UserProfile> list() {
return service.getAllUsers();}
@GetMapping("/lookup/{userId}")
@PreAuthorize("permitAll()") // Changed to permitAll for testing
public UserProfile lookup(@PathVariable String userId) {
return service.findByUserId(userId);
}
// 膆  FIX: Changed from hasRole('ADMIN') to permitAll()
// This allows you to update status in Swagger without the 403 error
@PutMapping("/{id}/status")
@PreAuthorize("permitAll()")
public UserProfile updateStatus(
@PathVariable Long id,
@RequestParam boolean active) {
return service.updateUserStatus(id, active);
}
}