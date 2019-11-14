package com.horiaconstantin.ctci.treesandgraphs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class BaseGraph {

    List<Node> nodes;
}
