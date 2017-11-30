# Some personal CSV benchmarking

The purpose of this benchmark is to compare 5 CSV parser in order to evaluate the fastest one.
For each parser, the final values are an average of 100 full import operations. To ensure the most precise results as possible,
 the first 10 tests of each parser have not been considered due to ![system warm-up period](https://dzone.com/articles/why-many-java-performance-test).
 For the same reason, all tests run independently and not one following other.

### Results (without quotes):

|          Parser          | Min Time | Max Time | AVG Time |     %     |
|:------------------------:|:--------:|:--------:|:--------:|:---------:|
| uniVocity 2.5.9          |    144   |    263   |  170.50  |     /     |
| SimpleFlatMapper 3.15.1  |    148   |    275   |  177.89  |  + 4.33%  |
| Jackson-dataformat 2.8.8 |    192   |    260   |  199.26  |  + 16.87% |
| OpenCSV 4.0              |    212   |    334   |  246.67  |  + 44.67% |
| Commons Csv 1.5          |    460   |    505   |  474.44  | + 178.28% |

### Graphical executions: