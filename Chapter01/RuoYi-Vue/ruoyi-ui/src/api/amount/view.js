import request from '@/utils/request'

// 查询VIEW列表
export function listView(query) {
  return request({
    url: '/amount/view/list',
    method: 'get',
    params: query
  })
}

export function queryNewFromList(query) {
  return request({
    url: '/amount/view/queryNewFromList',
    method: 'get',
    params: query
  })
}

// 查询VIEW详细
export function getView(days) {
  return request({
    url: '/amount/view/' + days,
    method: 'get'
  })
}

// 新增VIEW
export function addView(data) {
  return request({
    url: '/amount/view',
    method: 'post',
    data: data
  })
}

// 修改VIEW
export function updateView(data) {
  return request({
    url: '/amount/view',
    method: 'put',
    data: data
  })
}

// 删除VIEW
export function delView(days) {
  return request({
    url: '/amount/view/' + days,
    method: 'delete'
  })
}

// 导出VIEW
export function exportView(query) {
  return request({
    url: '/amount/view/export',
    method: 'get',
    params: query
  })
}