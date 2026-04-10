import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TrainConsistManagementAppTest {

  @Test
  void testFilter_CapacityGreaterThanThreshold() {
    List<TrainConsistManagementApp.Bogie> bogies = List.of(
        new TrainConsistManagementApp.Bogie("Sleeper", 72),
        new TrainConsistManagementApp.Bogie("General", 90));
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 70)
        .collect(Collectors.toList());
    assertEquals(2, result.size());
  }

  @Test
  void testFilter_CapacityEqualToThreshold() {
    List<TrainConsistManagementApp.Bogie> bogies = List.of(
        new TrainConsistManagementApp.Bogie("Sleeper", 70));
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 70)
        .collect(Collectors.toList());
    assertTrue(result.isEmpty());
  }

  @Test
  void testFilter_CapacityLessThanThreshold() {
    List<TrainConsistManagementApp.Bogie> bogies = List.of(
        new TrainConsistManagementApp.Bogie("AC Chair", 56));
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 70)
        .collect(Collectors.toList());
    assertTrue(result.isEmpty());
  }

  @Test
  void testFilter_MultipleBogiesMatching() {
    List<TrainConsistManagementApp.Bogie> bogies = List.of(
        new TrainConsistManagementApp.Bogie("Sleeper", 72),
        new TrainConsistManagementApp.Bogie("General", 90),
        new TrainConsistManagementApp.Bogie("AC Chair", 56));
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 60)
        .collect(Collectors.toList());
    assertEquals(2, result.size());
  }

  @Test
  void testFilter_NoBogiesMatching() {
    List<TrainConsistManagementApp.Bogie> bogies = List.of(
        new TrainConsistManagementApp.Bogie("First Class", 24));
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 70)
        .collect(Collectors.toList());
    assertTrue(result.isEmpty());
  }

  @Test
  void testFilter_AllBogiesMatching() {
    List<TrainConsistManagementApp.Bogie> bogies = List.of(
        new TrainConsistManagementApp.Bogie("Sleeper", 72),
        new TrainConsistManagementApp.Bogie("General", 90));
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 60)
        .collect(Collectors.toList());
    assertEquals(2, result.size());
  }

  @Test
  void testFilter_EmptyBogieList() {
    List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
    List<TrainConsistManagementApp.Bogie> result = bogies.stream()
        .filter(b -> b.capacity > 60)
        .collect(Collectors.toList());
    assertTrue(result.isEmpty());
  }

  @Test
  void testFilter_OriginalListUnchanged() {
    List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>(List.of(
        new TrainConsistManagementApp.Bogie("Sleeper", 72)));
    int originalSize = bogies.size();
    bogies.stream().filter(b -> b.capacity > 80).collect(Collectors.toList());
    assertEquals(originalSize, bogies.size());
  }
}
