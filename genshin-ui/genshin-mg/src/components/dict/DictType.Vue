<template xmlns="http://www.w3.org/1999/html">
  <div style="overflow: hidden;">
    <el-container style="height: 89vh">
      <el-aside style="width:150px;">
        <el-input placeholder="输入关键字进行过滤" v-model="outher.filterText" size="mini" @change="filterChange"></el-input>
        <el-tree
          style="margin-top: 10px"
          accordion
          class="filter-tree"
          :data="dictTypeTree"
          :expand-on-click-node="false"
          :highlight-current="true"
          :filter-node-method="filterNode"
          ref="tree">
        </el-tree>
      </el-aside>

      <el-container style="height: 89vh">
        <el-main>
          <el-card class="box-card" style="height: 100%">
            <el-form :label-position="left" :inline="true" >
              <el-form-item label="字典类型">
                <el-input v-model="dictForm.dictType" placeholder="请输入字典类型" size="mini" style="width: 120px"></el-input>
              </el-form-item>
              <el-form-item label="字典名称">
                <el-input v-model="dictForm.dictName" placeholder="请输入字典名称" label-width="100px" size="mini" style="width: 120px"></el-input>
              </el-form-item>
              <el-form-item label="状态">

              </el-form-item>
            </el-form>
            <el-button type="primary" size="mini">查询</el-button>
            <el-button type="primary" size="mini">重置</el-button>


            <template>
              <el-button type="primary" @click="addDict" size="mini">新增</el-button>
              <el-button type="primary" size="mini">修改</el-button>
              <el-button type="primary" size="mini">删除</el-button>
            </template>

            <template>
              <el-table :data="dictTypeTable" style="margin-top: 15px;height: 90%" empty-text="暂无数据">
                <el-table-column type="selection" width="40"></el-table-column>
                <el-table-column prop="dictName" label="菜单名称"></el-table-column>
                <el-table-column prop="dictType" label="菜单URL"></el-table-column>
                <!--                <el-table-column prop="parentId" label="父菜单ID"></el-table-column>-->
                <!--                <el-table-column prop="state" label="状态">-->
                <!--                  <template slot-scope="scope">-->
                <!--                    <el-tag type="success" v-if="scope.row.state == '0'" size="mini">正常</el-tag>-->
                <!--                    <el-tag type="danger" v-if="scope.row.state == '1'" size="mini">失效</el-tag>-->
                <!--                  </template>-->
                <!--                </el-table-column>-->
                <!--                <el-table-column prop="sort" label="排序"></el-table-column>-->
                <!--                <el-table-column prop="createTime" label="创建时间"></el-table-column>-->
                <!--                <el-table-column prop="updateTime" label="更新时间"></el-table-column>-->
                <!--                <el-table-column prop="remark" label="备注"></el-table-column>-->
              </el-table>
            </template>

            <div style="margin-top: 10px;text-align: right;">
              <el-pagination
                :current-page="dictForm.page"
                :page-sizes="[10, 20, 50, 100]"
                :page-size="dictForm.pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="outher.total">
              </el-pagination>
            </div>
          </el-card>
        </el-main>
      </el-container>
    </el-container>

    <!--弹框-新增页面-->
    <el-dialog title="新增字典类型" :visible.sync="outher.addButtonVisible" width="70%" :close-on-click-modal="false">
      <el-card>
        <el-form>
          <el-form-item label="字典名称">
            <el-input v-model="dictForm.dictName" placeholder="请输入字典名称"></el-input>
          </el-form-item>
          <el-form-item label="字典类型">
            <el-input v-model="dictForm.dictType" placeholder="请输入字典类型"></el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-radio-group v-model="dictForm.status" size="mini">
              <el-radio-button label="1">正常</el-radio-button>
              <el-radio-button label="2">停用</el-radio-button>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="dictForm.remark" placeholder="请输入备注"></el-input>
          </el-form-item>
        </el-form>
        <el-button type="primary" @click="saveDictType">确 定</el-button>
        <el-button @click="outher.addButtonVisible = false">取 消</el-button>
      </el-card>
    </el-dialog>
  </div>
</template>

<script>
import dictType from '@/api/dict/dictType'

export default {
  data() {
    return {
      outher: {
        filterText: "",
        total: 0,
        addButtonVisible: false,
      },
      dictForm: {
        dictName: '',
        dictType: '',
        status: '1',
        remark: '',
        page: 1,
        pageSize: 10,
      },
      dictTypeTree: [],
      dictTypeTable: [],
    };
  },
  mounted() {
    this.queryTable()
    this.queryTree()
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    filterChange() {
      // 这里每当输入的数据有变化就触发原生的过滤节点这个函数
      this.$refs.tree.filter(this.outher.filterText);
    },
    queryTree() {
      dictType.qryTree().then(response => {
        this.dictTypeTree = response.object;
      })
    },
    queryTable() {
      dictType.qryTable(this.dictForm).then(response => {
        this.dictTypeTable = response.object;
      })
    },
    saveDictType() {
      dictType.svDictType(this.dictForm);
    },
    addDict() {
      this.outher.addButtonVisible = true;
    }
  }
}
</script>

<style>

</style>
