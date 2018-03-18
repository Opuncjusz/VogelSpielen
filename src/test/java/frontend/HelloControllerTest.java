// package frontend;
//
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
// import org.junit.Assert;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
// import
// org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
// import common.AnswerTO;
// import test.TestApplicationContext;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest(classes = TestApplicationContext.class)
// @AutoConfigureMockMvc
// public class HelloControllerTest {
//
// @Autowired
// private MockMvc mvc;
//
// @Test
// public void areServicesAvailable() {
// try {
// mvc.perform(MockMvcRequestBuilders.post("/status/" +
// System.currentTimeMillis())
// .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
// } catch (Exception e) {
// Assert.fail(e.getMessage());
// }
//
// try {
// mvc.perform(MockMvcRequestBuilders.post("/desire/put/" +
// System.currentTimeMillis())
// .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
// } catch (Exception e) {
// Assert.fail(e.getMessage());
// }
//
// try {
// mvc.perform(MockMvcRequestBuilders.post("/desire/delete/" +
// System.currentTimeMillis())
// .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
// } catch (Exception e) {
// Assert.fail(e.getMessage());
// }
// }
//
// @Test
// public void getHello() throws Exception {
// MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
// MockMvcRequestBuilders.get("/status/123");
//
// MvcResult mvcResult = mvc.perform(mockHttpServletRequestBuilder).andReturn();
//
// AnswerTO answerTO = (AnswerTO)
// mvcResult.getModelAndView().getModel().get("answerTO");
//
// System.out.println("answerTO = " + answerTO);
// }
// }
