<template>
  <div id="HelloWorld">
    <label>{{mess}}</label>
   这是首页 <button @click="getMessage()">获取数据</button>
  </div>
</template>
<script>
  import Axios from "axios"
export default {
  name: 'HelloWorld',
  data () {
    return {
      mess: ''
    }
  },
  methods: {
    getMessage () {
      let url = "http://localhost:8082/vue/ajax";
      Axios.get(url).then(respose => {
        this.mess = respose.data;
      })
    }
  }
}
</script>

</style>
