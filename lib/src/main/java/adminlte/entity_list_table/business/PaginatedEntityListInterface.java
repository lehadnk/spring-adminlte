package adminlte.entity_list_table.business;

import java.util.List;

public interface PaginatedEntityListInterface<TEntityClass> {
    public List<TEntityClass> getEntities();
    public int getCurrentPage();
    public int getTotalPages();
}
