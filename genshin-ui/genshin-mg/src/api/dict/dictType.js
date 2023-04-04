import request from '@/utils/request'

export default {
  tree() {
    return request({
      url: '/sys/dictType/tree/',
      method: 'GET'
    })
  },
  qryTable(data){
    return request({
      url: '/sys/dictType/page/',
      method: 'POST',
      data: data
    })
  }
}
