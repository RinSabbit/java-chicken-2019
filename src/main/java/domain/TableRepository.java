package domain;

import exception.ChickenException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {

    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table getTable(int number) {
        return tables.stream()
            .filter(table -> table.isTable(number))
            .findFirst()
            .orElseThrow(() -> new ChickenException("없는 테이블입니다."));
    }
}
