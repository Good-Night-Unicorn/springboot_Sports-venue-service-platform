<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"padding":"0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"100%"}'>
				<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"20rpx 0","alignItems":"center","background":"#fff","display":"flex","height":"auto"}'>
					<view :style='{"margin":"0 12rpx","flex":"1","position":"relative"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"rgb(153, 153, 153)","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input :style='{"border":"2rpx solid #7C6047","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"0","background":"#fff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.yudingbianhao" type="text" placeholder="预定编号" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0 0 0 -152rpx","color":"#fff","borderRadius":"0","background":"#7C6047","width":"136rpx","lineHeight":"70rpx","fontSize":"28rpx","height":"70rpx","zIndex":"11"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"width":"100%","padding":"10rpx","margin":"0","flexWrap":"wrap","background":"#F6F6F6","display":"flex"}'>
					<view @click="sortClick('addtime')" :style='{"border":"2rpx solid #7C6047","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"0","background":"#FFFBF7","display":"flex"}'>
						<text :style='{"color":"#7C6047","lineHeight":"40rpx","fontSize":"24rpx"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"40rpx","fontSize":"24rpx","color":"#7C6047"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"40rpx","fontSize":"24rpx","color":"#7C6047"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"40rpx","fontSize":"24rpx","color":"#7C6047"}'></text>
					</view>
				</view>
				<view :style='{"width":"100%","background":"#fff","height":"auto"}'>
			
					<!-- 样式3 -->
					<view v-if="lists.length" class="list-box4" :style='{"width":"100%","padding":"20rpx 0","margin":"0","height":"auto"}'>
						<block v-for="(list,index) in lists" :key="index">
							<view v-if="list.length>0" @tap="onDetailTap(list[0])" class="list-item" :style='{"padding":"0","margin":"0 0 20rpx","borderColor":"#7C6047","borderWidth":"0 0 2rpx","width":"100%","borderStyle":"solid","height":"auto"}'>
								<view :style='{"width":"100%","position":"relative","height":"auto"}'>
					
									<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-if="preHttp(list[0].changguantupian)" :src="list[0].changguantupian"></image>
									<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-else :src="list[0].changguantupian?baseUrl+list[0].changguantupian.split(',')[0]:''"></image>
	
									<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>
										<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[0].changguanmingcheng}}</view>
										<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[0].shijianduan}}</view>
										<view :style='{"padding":"0 20rpx","order":"5"}'>
											<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"22rpx","color":"#DAA362"}'></text>
											<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"22rpx"}'>{{list[0].addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
										</view>
										<view :style='{"padding":"0 20rpx","display":"inline-block","order":"6"}'>
											<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
											<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{list[0].zhanghao}}</text>
										</view>
									</view>
								</view>
								<!-- #ifdef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdate" :data-row="list[0]">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDelete" :data-row="list[0]">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
								<!-- #ifndef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdateTap(list[0])">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDeleteTap(list[0].id)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
							</view>
							
							<view v-if="list.length>1" class="list-item-body" :style='{"width":"100%","padding":"0","margin":"0 0 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view v-if="list.length>1" @tap="onDetailTap(list[1])" :style='{"padding":"0","margin":"0","borderColor":"#7C6047","borderWidth":"0 0 2rpx","width":"48%","borderStyle":"solid","height":"auto"}'>
									<view :style='{"width":"100%","position":"relative","height":"auto"}'>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-if="preHttp(list[1].changguantupian)" :src="list[1].changguantupian"></image>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-else :src="list[1].changguantupian?baseUrl+list[1].changguantupian.split(',')[0]:''"></image>
										<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[1].changguanmingcheng}}</view>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[1].shijianduan}}</view>
											<view :style='{"padding":"0 20rpx","order":"5"}'>
												<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"22rpx","color":"#DAA362"}'></text>
												<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"22rpx"}'>{{list[1].addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
											</view>
											<view :style='{"padding":"0 20rpx","display":"inline-block","order":"6"}'>
												<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
												<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{list[1].zhanghao}}</text>
											</view>
										</view>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdate" :data-row="list[1]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDelete" :data-row="list[1]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdateTap(list[1])">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDeleteTap(list[1].id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
						
								<view v-if="list.length>2" @tap="onDetailTap(list[2])" :style='{"padding":"0","margin":"0","borderColor":"#7C6047","borderWidth":"0 0 2rpx","width":"48%","borderStyle":"solid","height":"auto"}'>
									<view :style='{"width":"100%","position":"relative","height":"auto"}'>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-if="preHttp(list[2].changguantupian)" :src="list[2].changguantupian"></image>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-else :src="list[2].changguantupian?baseUrl+list[2].changguantupian.split(',')[0]:''"></image>
										<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[2].changguanmingcheng}}</view>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[2].shijianduan}}</view>
											<view :style='{"padding":"0 20rpx","order":"5"}'>
												<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"22rpx","color":"#DAA362"}'></text>
												<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"22rpx"}'>{{list[2].addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
											</view>
											<view :style='{"padding":"0 20rpx","display":"inline-block","order":"6"}'>
												<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
												<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{list[2].zhanghao}}</text>
											</view>
										</view>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdate" :data-row="list[2]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDelete" :data-row="list[2]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdateTap(list[2])">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDeleteTap(list[2].id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
							</view>
							
							<view v-if="list.length>3" @tap="onDetailTap(list[3])" class="list-item" :style='{"padding":"0","margin":"0 0 20rpx","borderColor":"#7C6047","borderWidth":"0 0 2rpx","width":"100%","borderStyle":"solid","height":"auto"}'>
								<view :style='{"width":"100%","position":"relative","height":"auto"}'>
									<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"270rpx"}' mode="aspectFill" v-if="preHttp(list[3].changguantupian)" :src="list[3].changguantupian"></image>
									<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"270rpx"}' mode="aspectFill" v-else :src="list[3].changguantupian?baseUrl+list[3].changguantupian.split(',')[0]:''"></image>
									<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>
										<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[3].changguanmingcheng}}</view>
										<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[3].shijianduan}}</view>
										<view :style='{"padding":"0 20rpx","order":"5"}'>
											<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"22rpx","color":"#DAA362"}'></text>
											<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"22rpx"}'>{{list[3].addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
										</view>
										<view :style='{"padding":"0 20rpx","display":"inline-block","order":"6"}'>
											<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
											<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{list[3].zhanghao}}</text>
										</view>
									</view>
								</view>
								<!-- #ifdef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdate" :data-row="list[3]">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDelete" :data-row="list[3]">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
								<!-- #ifndef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdateTap(list[3])">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDeleteTap(list[3].id)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
							</view>
								
							<view v-if="list.length>4" class="list-item-body" :style='{"width":"100%","padding":"0","margin":"0","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view v-if="list.length>4" @tap="onDetailTap(list[4])" :style='{"padding":"0","margin":"0","borderColor":"#7C6047","borderWidth":"0 0 2rpx","width":"48%","borderStyle":"solid","height":"auto"}'>
									<view :style='{"width":"100%","position":"relative","height":"auto"}'>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-if="preHttp(list[4].changguantupian)" :src="list[4].changguantupian"></image>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-else :src="list[4].changguantupian?baseUrl+list[4].changguantupian.split(',')[0]:''"></image>
										<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[4].changguanmingcheng}}</view>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[4].shijianduan}}</view>
											<view :style='{"padding":"0 20rpx","order":"5"}'>
												<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"22rpx","color":"#DAA362"}'></text>
												<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"22rpx"}'>{{list[4].addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
											</view>
											<view :style='{"padding":"0 20rpx","display":"inline-block","order":"6"}'>
												<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
												<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{list[4].zhanghao}}</text>
											</view>
										</view>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdate" :data-row="list[4]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDelete" :data-row="list[4]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdateTap(list[4])">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDeleteTap(list[4].id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
								
								<view v-if="list.length>5" @tap="onDetailTap(list[5])" :style='{"padding":"0","margin":"0","borderColor":"#7C6047","borderWidth":"0 0 2rpx","width":"48%","borderStyle":"solid","height":"auto"}'>
									<view :style='{"width":"100%","position":"relative","height":"auto"}'>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-if="preHttp(list[5].changguantupian)" :src="list[5].changguantupian"></image>
										<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' mode="aspectFill" v-else :src="list[5].changguantupian?baseUrl+list[5].changguantupian.split(',')[0]:''"></image>
										<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[5].changguanmingcheng}}</view>
											<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="title">{{list[5].shijianduan}}</view>
											<view :style='{"padding":"0 20rpx","order":"5"}'>
												<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"22rpx","color":"#DAA362"}'></text>
												<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"22rpx"}'>{{list[5].addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
											</view>
											<view :style='{"padding":"0 20rpx","display":"inline-block","order":"6"}'>
												<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
												<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{list[5].zhanghao}}</text>
											</view>
										</view>
									</view>
									<!-- #ifdef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdate" :data-row="list[5]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDelete" :data-row="list[5]">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
									<!-- #ifndef MP-WEIXIN -->
									<view :style='{"width":"100%","padding":"8rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
										<view :style='{"border":"2rpx solid #7C6047","width":"45%","justifyContent":"center","display":"flex","order":"1"}' v-if="(userid && isAuth('changguanyuding','修改')) || (!userid && isAuthFront('changguanyuding','修改'))" @tap.stop.proevent="onUpdateTap(list[5])">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}' class="cuIcon-edit"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#7C6047","display":"inline-block"}'>修改</text>
										</view>
										<view :style='{"border":"2rpx solid #C4BCA9","width":"45%","justifyContent":"center","display":"flex"}' v-if="(userid && isAuth('changguanyuding','删除')) || (!userid && isAuthFront('changguanyuding','删除'))" @tap.stop.proevent="onDeleteTap(list[5].id)">
											<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}' class="cuIcon-delete"></text>
											<text :style='{"fontSize":"28rpx","lineHeight":"40rpx","color":"#C4BCA9","display":"inline-block"}'>删除</text>
										</view>
									</view>
									<!-- #endif -->
								</view>
							</view>
						</block>
					</view>
			
			


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #00000030","color":"#fff","bottom":"40rpx","outline":"none","borderRadius":"100%","left":"8rpx","background":"#7C6047","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' class="add-btn" @click="screenBoxShow=true">筛</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"#7C6047","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('changguanyuding','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"#7C6047","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('changguanyuding','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<view :style='{"top":"0","left":"0","background":"rgba(0, 0, 0, .3)","width":"100%","position":"absolute","height":"100%","zIndex":"665"}' v-if="screenBoxShow" @click="screenBoxShow=false"></view>
				<view class="screenBox" :class="screenBoxShow?'screenBoxActive':''">
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0"}'>
						<view :style='{"width":"100%","padding":"0 0 20rpx 20rpx","fontSize":"22rpx","color":"#858585"}'>是否支付</view>
						<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-around","display":"flex"}'>
							<view @click="ispayChange(item)" v-for="(item,index) in ispayOptions" :key="index" class="screenTab" :class="searchForm.ispay==item?'screenTabActive':''">{{item}}</view>
						</view>
					</view>
					<view :style='{"width":"100%","padding":"40rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<div :style='{"width":"50%","lineHeight":"60rpx","color":"#858585","textAlign":"center","background":"#EDEDED","height":"60rpx"}' @click="screenReset">重置</div>
						<div :style='{"width":"50%","lineHeight":"60rpx","color":"#fff","textAlign":"center","background":"#7C6047","height":"60rpx"}' @click="search">搜索</div>
					</view>
				</view>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				ispayOptions: ['已支付','未支付'],
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					yudingbianhao: '',
					ispay: '',
				},
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			ispayChange(e){
				this.searchForm.ispay = e
				this.$forceUpdate()
			},
			screenReset(){
				this.searchForm = {}
				this.$forceUpdate()
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: 6,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.searchForm.yudingbianhao){
					params['yudingbianhao'] = '%' + this.searchForm.yudingbianhao + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`changguanyuding`, params);
                } else {
                    params['sfsh'] = '是';
                    res = await this.$api.list(`changguanyuding`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
				if(row.sfsh=='是'||row.sfsh=='否'){
					this.$utils.msg('已审核完成,不能修改');
					return false
				}
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('changguanyuding', JSON.stringify([id]));
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: 6,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.ispay){
					searchForm['ispay'] = this.searchForm.ispay
				}
				if(this.searchForm.yudingbianhao){
					searchForm['yudingbianhao'] = '%' + this.searchForm.yudingbianhao + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`changguanyuding`, searchForm);
                } else {
                    searchForm['sfsh'] = '是';
                    res = await this.$api.list(`changguanyuding`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx;
		color: #fff;
		background: none;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		border-radius: 0 0 20rpx 20rpx;
		padding: 0 20rpx;
		color: #7C6047;
		background: #fff;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	.screenBox {
		border-radius: 40rpx 40rpx 0 0;
		padding: 20rpx 0 0;
		transform: translate3d(100%, 0, 0);
		z-index: 666;
		background: #fff;
		bottom: 0;
		display: block;
		width: 100%;
		position: absolute;
		right: 0;
		transition: transform .3s;
		height: auto;
		.screenTab {
			border: 2rpx solid #CCCCCC;
			border-radius: 4rpx;
			margin: 10rpx 0 10rpx 0;
			background: #fff;
			width: calc(100% / 3 - 60rpx);
			line-height: 50rpx;
			text-align: center;
		}
		.screenTabActive {
			border-radius: 4rpx;
			margin: 10rpx 0 10rpx 0;
			color: #fff;
			background: #7C6047;
			width: calc(100% / 3 - 60rpx);
			line-height: 50rpx;
			text-align: center;
		}
	}
	.screenBoxActive {
		transform: translate3d(0, 0, 0);
		display: block;
	}
</style>
