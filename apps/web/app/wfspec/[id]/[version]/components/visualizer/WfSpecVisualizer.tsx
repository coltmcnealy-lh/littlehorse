'use client'
import React, { useEffect, useState } from 'react'
import { WfSpecVisualizerChart } from './WfSpecVisualizerChart'
import { Drawer } from '../../../../../../components/Drawer/Drawer'
import {
	getMainDrawerData,
	nodeTypes
} from '../../../../../../components/Drawer/internals/drawerInternals'
import WFRunInformationSideBar from '../../../../../../components/WFRunInformationSideBar'
import { Loader } from 'ui'
import { WfSpecDrawerComponent } from '../../../../../../components/Drawer/WfSpecDrawerComponent'

interface mapnode {}
export const WfSpecVisualizer = ({
	id,
	version
}: {
	id: string
	version: number
}) => {
	const [rawdata, setRawData] = useState<any[]>([])
	const [data, setData] = useState<any[]>([])
	const [drawerData, setDrawerData] = useState<any>()
	const [selectedNodeName, setSelectedNodeName] = useState<any>()
	const [nodeType, setNodeType] = useState<string | undefined>()
	const [loading, setLoading] = useState(true);

	const [language, setLanguage] = useState<any>();
	const [showError, setShowError] = useState(false)
	const [toggleSideBar, setToggleSideBar] = useState(false)
	const [sideBarData, setSideBarData] = useState('')

	const rec = (mappedData, i, offset, open=false) => {
		
		let graphNode = mappedData[i]

		// console.log(el.name,offset, +el.position)
		graphNode.level= +graphNode.position + offset

		if (!graphNode.childs.length) {
			return mappedData //if not childs close the REC function
		}
		
		if (graphNode.type === 'WAIT_FOR_THREAD') {
			let wft = graphNode.node.waitForThread.threadRunNumber.variableName
			let thread = mappedData.find(m => m.name === wft)
			graphNode.wlevel = thread.level
		}
		
		let addo = 0
		if(graphNode.type === 'NOP' ){
			if(open){
				graphNode.closer = true
				open = false
			}else{
				open = true
				addo = 1
			}
		}
		
		mappedData = mappedData.map(m => {
			if (graphNode.childs.includes(m.name)) {
				// m.level = graphNode.level + 1 // each child heritate parent level + 1

				// CHECK IF NOP IS WHILE
				if(graphNode.type === 'NOP' && m.type==='NOP'){
					const econd =  graphNode.node.outgoingEdges.find(e => e.sinkNodeName != m.name)?.condition || {}
					const mcond = m.node.outgoingEdges.find(e => e.sinkNodeName === graphNode.name)?.condition || {}
					if(JSON.stringify(econd) === JSON.stringify(mcond)){
						graphNode.while = true
						m.while = true
					}
				}

				if(m.type === 'NOP' ){
					m.px = 'center'
				}else{
					m.px = graphNode.px
				}

				if (graphNode.childs.length > 1 && (m.type != 'NOP') ) {
					// m.level = el.level + 2
					m.px = m.name === graphNode.childs[0] ? 'left' : 'right'
				}
				// if(m.type === 'NOP' && m.childs.length === 1){
	
				if(m.type === 'NOP' && open){
					graphNode.cNOP = m.name
				}
				if(!open){
					m.px = 'center'
				}

			}
			return m
		})
		// console.log(addo)
		return rec(mappedData, ++i, offset+addo, open)
	}
	const mapData = (data: any, thread?: string) => {
		const threads = Object.keys(data?.threadSpecs)
		const print_thread = thread || threads[0]
		const entries = Object.entries(data?.threadSpecs?.[print_thread]?.nodes)
		const mappedData: any = entries.map((e: mapnode) => ({
			name: e[0],
			type: e[0].split('-').pop(),
			position: e[0].split("-").shift(),
			node: e[1],
			childs: e[1]['outgoingEdges'].map(e => e.sinkNodeName),
			level: 0,
			closer:false,
			while:false,
			px: 'center'
		}))

		const dataSortedByName = mappedData.sort((a,b) => a.name > b.name ? 1 : -1)

		setLoading(false);

		// Hardcoded value for the fraud-detection-form example
		mappedData[5].position = 3
		return rec(dataSortedByName, 0, 0)
	}
	const getData = async () => {
		const res = await fetch('/api/visualization/wfSpec', {
			method: 'POST',
			body: JSON.stringify({
				id,
				version
			})
		})
		if (res.ok) {
			const content = await res.json()
			setRawData(content)
			setData(mapData(content))
		}
	}
	const setThread = (thread:string) => {
		setSelectedNodeName(undefined)
		setData(mapData(rawdata,thread))
	}

	useEffect(() => {
		if (drawerData === undefined) getMainDrawerData(id, setDrawerData)

		if (selectedNodeName) {
			const nodePostFix = selectedNodeName.split('-').reverse()[0]

			setNodeType(nodeTypes[nodePostFix as keyof typeof nodeTypes])
		}
	}, [drawerData, selectedNodeName])

	const drawerInternal = (
		<WfSpecDrawerComponent
			internalComponent={nodeType}
			datao={data}
			data={drawerData}
			nodeName={selectedNodeName}
			wfSpecId={id}
			setToggleSideBar={setToggleSideBar}
			setCode={setSideBarData}
			setLanguage={setLanguage}
			setError={setShowError}
			setThread={setThread}
		/>
	)

	useEffect(() => {
		getData()
	}, [])
	return (
		<div className='visualizer'>
			<div
				className={`canvas scrollbar ${data.length === 0 ? 'flex items-center justify-items-center justify-center': ''}`}
			>
				{ loading ? <Loader /> : <WfSpecVisualizerChart data={data} onClick={setSelectedNodeName} />}
			</div>

			<Drawer title={'WfSpec Properties'}>{drawerInternal}</Drawer>
			<WFRunInformationSideBar
				toggleSideBar={toggleSideBar}
				setToggleSideBar={setToggleSideBar}
				output={sideBarData}
				errorLog={showError}
				language={language}
			/>
		</div>
	)
}
