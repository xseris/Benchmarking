# Some personal JSON benchmarking

The purpose of this benchmark is to compare 5 JSON serializer in order to evaluate the fastest one.
For each serializer, the final values are an average of 100 full POJO serialize and deserialize operations. To ensure the most precise results as possible, the first 10 tests of each parser have not been considered due to [system warm-up](https://dzone.com/articles/why-many-java-performance-test) period. For the same reason, all tests run independently and not one following other.
 
# Results

### Serialization Results:

|          Parser          | Min Time | Max Time | AVG Time |     %     |
|:------------------------:|:--------:|:--------:|:--------:|:---------:|
| FlexJson 3.3	           |    288   |    389   |  300.32  | + 329.24% |
| Gson 2.8.2               |    118   |    231   |  134.94  |  + 92.87% |
| Jackson 2.9.2            |    63    |    145   |  69.97   |  /        |
| Jsoniterator 0.9.18      |    69    |    97    |  73.13   |  + 4.53%  |
| Genson 1.4               |    67    |    144   |  78.19   | + 11.75%  |

### Deserialization Results:

|          Parser          | Min Time | Max Time | AVG Time |     %     |
|:------------------------:|:--------:|:--------:|:--------:|:---------:|
| FlexJson 3.3	           |    385   |    610   |  414.70  |     + 382.52%     |
| Gson 2.8.2               |    87    |    157   |  98.07   |  + 14.10%  |
| Jackson 2.9.2            |    109   |    160   |  118.24  |  + 37.58% |
| Jsoniterator 0.9.18      |    75    |    161   |  85.94   |  / |
| Genson 1.4               |    103   |    188   |  112.78  | + 31.22% |

### Graphical executions:

![serialization benchmarking](https://github.com/xseris/Benchmarking/blob/master/json/src/main/resources/images/runSerializer.jpg)
![deserialization benchmarking](https://github.com/xseris/Benchmarking/blob/master/json/src/main/resources/images/runDeserializer.jpg)


